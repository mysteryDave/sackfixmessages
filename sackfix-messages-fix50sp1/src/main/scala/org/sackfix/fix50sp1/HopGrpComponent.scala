package org.sackfix.fix50sp1

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.xml
  */
case class HopGrpComponent(noHopsField:Option[NoHopsField]=None,
                           hopsGroups: Option[List[HopsGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noHopsField.map(_.value).getOrElse(0) != hopsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoHopsField.TagId,noHopsField.map(_.value).getOrElse(0), hopsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noHopsField.foreach(fmt(b,_))
    hopsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object HopGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    HopsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoHopsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    HopsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    HopsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoHopsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = HopsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[HopGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(HopGrpComponent(myFields.get(NoHopsField.TagId).flatMap(f=>NoHopsField.decode(f)),
        if (nextTagPosLookup.contains(NoHopsField.TagId)) HopsGroup.decode(flds, nextTagPosLookup(NoHopsField.TagId)) else None))
    } else None
  }

    
}
     