package org.sackfix.fix50

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50.xml
  */
case class PreAllocMlegGrpComponent(noAllocsField:Option[NoAllocsField]=None,
                                    allocsGroups: Option[List[AllocsGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noAllocsField.map(_.value).getOrElse(0) != allocsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoAllocsField.TagId,noAllocsField.map(_.value).getOrElse(0), allocsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noAllocsField.foreach(fmt(b,_))
    allocsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object PreAllocMlegGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    AllocsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoAllocsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    AllocsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    AllocsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoAllocsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = AllocsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[PreAllocMlegGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(PreAllocMlegGrpComponent(myFields.get(NoAllocsField.TagId).flatMap(f=>NoAllocsField.decode(f)),
        if (nextTagPosLookup.contains(NoAllocsField.TagId)) AllocsGroup.decode(flds, nextTagPosLookup(NoAllocsField.TagId)) else None))
    } else None
  }

    
}
     