package org.sackfix.fix50

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50.xml
  */
case class LegPreAllocGrpComponent(noLegAllocsField:Option[NoLegAllocsField]=None,
                                   legAllocsGroups: Option[List[LegAllocsGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noLegAllocsField.map(_.value).getOrElse(0) != legAllocsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoLegAllocsField.TagId,noLegAllocsField.map(_.value).getOrElse(0), legAllocsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noLegAllocsField.foreach(fmt(b,_))
    legAllocsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object LegPreAllocGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    LegAllocsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoLegAllocsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    LegAllocsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    LegAllocsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoLegAllocsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = LegAllocsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[LegPreAllocGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(LegPreAllocGrpComponent(myFields.get(NoLegAllocsField.TagId).flatMap(f=>NoLegAllocsField.decode(f)),
        if (nextTagPosLookup.contains(NoLegAllocsField.TagId)) LegAllocsGroup.decode(flds, nextTagPosLookup(NoLegAllocsField.TagId)) else None))
    } else None
  }

    
}
     