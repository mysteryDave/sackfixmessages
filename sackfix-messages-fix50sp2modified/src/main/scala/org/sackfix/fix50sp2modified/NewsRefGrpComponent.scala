package org.sackfix.fix50sp2modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.modified.xml
  */
case class NewsRefGrpComponent(noNewsRefIDsField:Option[NoNewsRefIDsField]=None,
                               newsRefIDsGroups: Option[List[NewsRefIDsGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noNewsRefIDsField.map(_.value).getOrElse(0) != newsRefIDsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoNewsRefIDsField.TagId,noNewsRefIDsField.map(_.value).getOrElse(0), newsRefIDsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noNewsRefIDsField.foreach(fmt(b,_))
    newsRefIDsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object NewsRefGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    NewsRefIDsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoNewsRefIDsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    NewsRefIDsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    NewsRefIDsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoNewsRefIDsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = NewsRefIDsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[NewsRefGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(NewsRefGrpComponent(myFields.get(NoNewsRefIDsField.TagId).flatMap(f=>NoNewsRefIDsField.decode(f)),
        if (nextTagPosLookup.contains(NoNewsRefIDsField.TagId)) NewsRefIDsGroup.decode(flds, nextTagPosLookup(NoNewsRefIDsField.TagId)) else None))
    } else None
  }

    
}
     