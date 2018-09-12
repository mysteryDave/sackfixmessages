package org.sackfix.fix50sp1modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.modified.xml
  */
case class SideTrdRegTSComponent(noSideTrdRegTSField:Option[NoSideTrdRegTSField]=None,
                                 sideTrdRegTSGroups: Option[List[SideTrdRegTSGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noSideTrdRegTSField.map(_.value).getOrElse(0) != sideTrdRegTSGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoSideTrdRegTSField.TagId,noSideTrdRegTSField.map(_.value).getOrElse(0), sideTrdRegTSGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noSideTrdRegTSField.foreach(fmt(b,_))
    sideTrdRegTSGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object SideTrdRegTSComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    SideTrdRegTSGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoSideTrdRegTSField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    SideTrdRegTSGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    SideTrdRegTSGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoSideTrdRegTSField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = SideTrdRegTSGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SideTrdRegTSComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(SideTrdRegTSComponent(myFields.get(NoSideTrdRegTSField.TagId).flatMap(f=>NoSideTrdRegTSField.decode(f)),
        if (nextTagPosLookup.contains(NoSideTrdRegTSField.TagId)) SideTrdRegTSGroup.decode(flds, nextTagPosLookup(NoSideTrdRegTSField.TagId)) else None))
    } else None
  }

    
}
     