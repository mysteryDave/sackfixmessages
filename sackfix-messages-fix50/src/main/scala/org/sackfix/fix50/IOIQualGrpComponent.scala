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
case class IOIQualGrpComponent(noIOIQualifiersField:Option[NoIOIQualifiersField]=None,
                               iOIQualifiersGroups: Option[List[IOIQualifiersGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noIOIQualifiersField.map(_.value).getOrElse(0) != iOIQualifiersGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoIOIQualifiersField.TagId,noIOIQualifiersField.map(_.value).getOrElse(0), iOIQualifiersGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noIOIQualifiersField.foreach(fmt(b,_))
    iOIQualifiersGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object IOIQualGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    IOIQualifiersGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoIOIQualifiersField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    IOIQualifiersGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    IOIQualifiersGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoIOIQualifiersField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = IOIQualifiersGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[IOIQualGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(IOIQualGrpComponent(myFields.get(NoIOIQualifiersField.TagId).flatMap(f=>NoIOIQualifiersField.decode(f)),
        if (nextTagPosLookup.contains(NoIOIQualifiersField.TagId)) IOIQualifiersGroup.decode(flds, nextTagPosLookup(NoIOIQualifiersField.TagId)) else None))
    } else None
  }

    
}
     